# System Design Diagram


# Questions in table design

## Supplier - Product (M-to-N relationship)

M-to-N relationship between Suppliers and Brands: The relationship suggests that multiple suppliers can supply multiple brands, and vice versa, a brand could be associated with multiple suppliers. In such cases, a junction (or associative) table is used to bridge this relationship. Here's the modified database design:

### Relationships: Supllier, brand, category, product, sku

Given the added complexity of an M-N relationship between suppliers and brands, we need to adjust our database design to accommodate it. Let's delve into the relationships between these entities, considering this many-to-many association between suppliers and brands:

1. **Supplier to SupplierBrand**: Many-to-Many.
   - **Description**: A supplier can be associated with multiple brands, and a brand can be linked with multiple suppliers.
   - **Implementation**: This M-N relationship is represented through an associative table, `SupplierBrand`. Both `supplier_id` and `brand_id` act as foreign keys in this table. Each entry in `SupplierBrand` represents a unique combination of a supplier and a brand.

2. **Brand to SKU**: One-to-Many.
   - **Description**: A brand will have multiple SKUs representing its range of products.
   - **Implementation**: The `SKU` table contains a `brand_id` foreign key pointing to the `Brand` table.

3. **Supplier to SupplierProduct**: One-to-Many.
   - **Description**: One supplier can provide multiple distinct SKUs, but a specific combination of a supplier and an SKU is unique.
   - **Implementation**: The `SupplierProduct` table has a `supplier_id` and `sku_id` as foreign keys.

4. **SKU to SupplierProduct**: One-to-Many.
   - **Description**: An SKU can be sourced from multiple suppliers. Each entry in `SupplierProduct` denotes one such source.
   - **Implementation**: The `SupplierProduct` table has a `sku_id` foreign key linking back to the `SKU` table.

5. **SKU to Brand**: Many-to-One.
   - **Description**: Each SKU corresponds to a specific brand. However, one brand can have multiple SKUs.
   - **Implementation**: The `SKU` table has a `brand_id` as a foreign key.

6. **SKU to Category**: Many-to-One.
   - **Description**: An SKU is categorized under one category, but a category can have multiple SKUs.
   - **Implementation**: The `SKU` table has a `category_id` as a foreign key.

7. **Supplier to SupplierContact**: One-to-Many.
   - A supplier can have multiple contacts.

8. **Supplier to SupplierAudit**: One-to-Many.
   - One supplier can have multiple audit entries.


### Notes:

- The `SupplierBrand` associative table is the cornerstone for managing the M-N relationship between suppliers and brands. This table allows the system to flexibly represent situations where, for instance, multiple suppliers might provide products under the same brand (e.g., multiple distributors for a global brand), or a single supplier might supply products from various brands (e.g., a distributor supplying items from multiple manufacturers).

- The `SupplierProduct` table gives granularity about which exact SKUs are provided by which suppliers, making it essential for inventory, pricing, and sourcing operations.

By defining these relationships, the system can efficiently manage and query product information, brand associations, supplier details, and sourcing specifics.

## will SupplierProducts also contains brand_id?

Including `brand_id` in the `SupplierProducts` table directly is possible, but it's often **redundant** since the brand association can be derived from the `SKU` table (provided the `SKU` table is already linked to brands, as you previously described). Including the `brand_id` directly in the `SupplierProducts` table can lead to denormalization, which might make certain operations faster but can also introduce potential inconsistencies and maintenance challenges.

### Considerations:

1. **Redundancy**: If both the `SKU` table and the `SupplierProducts` table contain `brand_id`, it creates a redundant storage of brand information. Any change in brand association at the SKU level would require updates in multiple places.

2. **Data Integrity**: Redundancy can lead to data integrity issues. For instance, if the `brand_id` in the `SKU` table for a certain product changes, it should also be updated in the `SupplierProducts` table to maintain consistency.

3. **Derived Relationship**: The brand of a product (SKU) is an inherent characteristic of the product itself and not of the supply process. Therefore, it's more logical to link brands directly to SKUs in the `SKU` table and derive the brand from the `SKU` whenever needed in the context of the `SupplierProducts`.

### Suggested Approach:

We can fetch `brand_id` through a JOIN operation to ensure normalization, reducing redundancy, and maintaining data integrity

```sql
SELECT sp.supplier_id, sp.sku_id, sku.brand_id
FROM SupplierProducts sp
JOIN SKU sku ON sp.sku_id = sku.sku_id
WHERE sp.supplier_id = [specific_supplier_id];
```

### Relationships:

1. **Supplier to SupplierProducts**: One-to-Many.
   - One supplier can supply multiple product variants (SKUs).

2. **SKU to SupplierProducts**: One-to-Many.
   - One SKU can be supplied by multiple suppliers, especially in scenarios where multiple distributors or suppliers can provide the same product variant.

This structure enables clear mapping of which supplier provides which product variants (SKUs) to a brand, and at what price and quantity. It offers traceability and allows for operations like inventory management, cost analysis, and supplier performance tracking based on the products they supply.

The `SupplierProducts` table acts as a bridge or connecting table between the `SKU` (from `product-service`) and the `Supplier` table (from `supplier-service`). This bridge captures the many-to-many relationship between SKUs and Suppliers.

### Breakdown:

1. **SKU**: Each SKU represents a unique product variant in the `product-service`.
   
2. **Supplier**: Represents entities that provide these SKUs in the `supplier-service`.

3. **SupplierProducts**: This connecting table captures which suppliers provide which SKUs. Each entry in this table represents a specific instance of a supplier providing a particular SKU. 

- **Relationships**:
  - A single SKU can be provided by multiple suppliers.
  - Conversely, a single supplier can provide multiple SKUs.
  - The `SupplierProducts` table captures these relationships.

- **Fields** in `SupplierProducts` typically include:
  - A unique identifier for each entry (`supplier_product_id` or similar).
  - `supplier_id` as a Foreign Key pointing to the `Supplier` table.
  - `sku_id` as a Foreign Key pointing to the `SKU` table.
  - Additional fields like `supply_date`, `supply_price`, `quantity`, etc., to capture more details about the supply relationship.

By using the `SupplierProducts` table, the system can answer questions like:
- Which suppliers provide a specific SKU?
- Which SKUs are provided by a specific supplier?
- What's the supply price and quantity of a specific SKU from a particular supplier?

<!-- ### 1. Supplier:

- **Description**: Represents entities that supply products.

- **Fields**:
  - `supplier_id`: Primary Key.
  - `name`: Supplier or company name.
  - `address`: Supplier's primary address.
  - `contact_email`: Primary contact email.
  - `contact_number`: Primary contact phone number.
  - `bank_details`: Information for transactions.
  - `rating`: A system-generated or user-generated rating based on supplier performance.

### 2. Brand:

- **Description**: Represents different product brands.

- **Fields**:
  - `brand_id`: Primary Key.
  - `name`: Brand name.
  - `logo`: Brand logo.
  - `description`: Description of the brand.
  - `website`: Brand's official website link.

### 3. SupplierBrand (Junction Table):

- **Description**: Associates suppliers with brands, establishing the M-to-N relationship.

- **Fields**:
  - `supplier_brand_id`: Primary Key.
  - `supplier_id`: Foreign Key linking to the `Supplier` table.
  - `brand_id`: Foreign Key linking to the `Brand` table.
  - `association_date`: When this supplier-brand association was formed.
  - ... (other potential fields like contract details, terms of partnership, etc.)

### 4. SupplierContact:

- **Description**: Details of various contacts associated with the supplier.

- **Fields**:
  - `contact_id`: Primary Key.
  - `supplier_id`: Foreign Key linking to the `Supplier` table.
  - `name`: Contact person's name.
  - `email`: Contact email.
  - `phone`: Contact phone number.
  - `designation`: Role of the contact person within the supplier organization.

### 5. SupplierAudit:

- **Description**: For tracking changes or updates to the supplier data.

- **Fields**:
  - `audit_id`: Primary Key.
  - `supplier_id`: Foreign Key linking to the `Supplier` table.
  - `change_date`: Date and time when the change was made.
  - `changed_field`: The specific column or attribute that changed.
  - `old_value`: Previous value of the attribute.
  - `new_value`: Updated value of the attribute.

### 6. BrandProducts (Optional):

- **Description**: If a direct mapping between brands and their products is needed.

- **Fields**:
  - `brand_product_id`: Primary Key.
  - `brand_id`: Foreign Key linking to the `Brand` table.
  - `spu_id`: Foreign Key linking to the `SPU` table from the `Product-service`.
  - `added_date`: When this product was associated with the brand.
 -->
