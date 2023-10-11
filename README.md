# Quickmall Scrum Development Plan

| [Database Design](/1%20System%20Analysis%20Diagram/QuickMallDB.xlsx) | [Backend code](/3%20EcommerceBackend/) | [Project Kick-off](https://github.com/coco2023/QuickMall-eCommerce#1-preparation) | [Product Backlog](https://github.com/coco2023/QuickMall-eCommerce#2-product-backlog) | [Sprint Backlog](https://github.com/coco2023/QuickMall-eCommerce#3-sprint-backlog) |
|---|---|---|---|---|

![database](/2%20Documents/database.png)

## 1 Preparation [return to outline](https://github.com/coco2023/QuickMall-eCommerce#quickmall-scrum-development-plan)

-  **Project Vision**: Define the end goals for `quickmall` e-commerce backend. 
-  **Project Kick-off:**
   - **Auth-service**: create user and grant user role permissions (admin, supplier, customer, tester)
   - Strictly establish **product and** **supplier** **databases** according to e-commerce website standards.
   - Implement a **seamless shopping workflow**:
      - Enabled users to effortlessly **add items**, **review cart selections**, **create orders**, **finalize payments**, and **instantly receive purchase receipts**.
   - Implement **coupon messaging system**.
-  **Environment Setup**: 
   - Development: springframework:2.7.13-SNAPSHOT; 
   - Staging: For testing purposes.
   - Production: For the final live system.
-  **Tool Selection**: Tools like **Git** for version control, **JIRA** for task management, **Jenkins** for continuous integration and **AWS** for deployment.

## 2 Product Backlog [return to outline](https://github.com/coco2023/QuickMall-eCommerce#quickmall-scrum-development-plan)

-  **List Features**: Identify and list down features for each service. 
-  **Prioritize**: Arrange features based on their importance and dependencies. 
-  **Estimation**: Use story points to give an effort estimate to each feature. 

### **1 Product-service**

**User Stories**:

1.  **US201**: As a **customer**, I want to browse through **products**, their **brands**, **category**,  **details**, and **attributes**. 
       - Feature: Implement SKU, SPU, and their respective attributes in `product-service`.
2.  **US202**: As a **manager**, I want to categorize products and link them with brands. 
       - Feature: Utilize `category`, `categroy_brand` tables, and ensure brands are associated correctly with products.
3.  **US203**: As an **employee**, I want to view and manage the attributes and their groupings for products. 
       - Feature: Manage `attribute`, `attribut_group`, and `attribute_attribute_group` for detailed product information.

### **2 Supplier-service**

**User Stories**:

4.  **US204**: As a **manager**, I want to onboard suppliers and have an overview of the products they supply. 
       - Feature: Establish the `supplier`, `supplier_product`, and `supplier_brand` functionalities.
5.  **US205**: As a **supplier**, I want to manage my contact details and track audit logs. 
       - Feature: Develop the `supplier_contact` and `supplier_audit` functionalities.

### **3 User-service**

**User Stories**:

6. **US206**: As an **admin**, I want to allocate roles and permissions to users. 
   - Feature: RBAC implementation; specify roles such as **admin**, **supplier**, **customer**, and **tester(user)**.

### **4 Cart-service**

**User Stories**:

7. **US207**: As a **customer**, I want to add products to my cart and view them before purchasing. 
   - Feature: Add to and view cart contents, ensuring integration with product-service for real-time product details.

### **5 Order-service**

**User Stories**:

8. **US208**: As a **customer**, I want to convert my cart items into orders, verifying the details before making a payment. 
   - Feature: Create and manage order details, linking products selected from the cart.

### **6 Payment-service**

**User Stories**:

9. **US209**: As a **customer**, I want a seamless payment experience with confirmation notifications. 
   - Feature: Securely process payments and send success notifications back to order-service.

### **7 Coupon-service**

**User Stories**:

10. **US210**: As a **customer**, I want to use coupons during checkout to avail discounts.
    - Feature: Handle coupon validations, applying appropriate discounts to orders.

11. **US211**: As a **manager**, I want to create and manage coupon promotions.
    - Feature: Establish a system for creating, updating, and deactivating coupons.

### **8 Technical Debt and Bugs**

12. **TD201**: Implement centralized logging across microservices for better traceability.
13. **TD202**: Improve inter-service communication resilience; consider circuit breakers.
14. **BUG201**: Address any latency issues during cart to order transition.
15. **BUG202**: Rectify any discrepancies in calculating discounts with coupons.

### **9 Improvements and Research**

16. **IMP201**: Research potential integrations with external payment gateways to expand payment options.
17. **IMP202**: Explore options for a recommendation engine to suggest products to users based on their behavior.

## 3 Sprint Backlog [return to outline](https://github.com/coco2023/QuickMall-eCommerce#quickmall-scrum-development-plan)

For each sprint, there will be a clear sprint goal.

### **Sprint 1: Basic Setup & User Service Start**

- **Goal**: Establish foundational elements and set up basic user roles and authentication.
- **Tasks**: 
   - Initialize the user-service.
   - Implement roles: admin, supplier, customer, user(tester).
   - Create authentication mechanisms and CRUD operations.

### **Sprint 2: Complete User Service & Begin Product Service**

- **Goal**: Complete the user-service and initiate the Product-service.
- **Tasks**: 
   - Complete the remaining tables and functionalities for the user-service
   - Initialize the product-service.
   - Setup tables: SKU, SPU, brand, category, and their junction tables.
   - Develop CRUD operations for these tables.

### **Sprint 3:  Finish Advanced Product Attributes & Initiate Supplier Basics**

- **Goal**: Enhance product details and introduce suppliers.
- **Tasks**: 
   - Extend product-service with tables: attribute, attribute_group, junction tables, etc.
   - Start supplier-service with basic supplier details.

### **Sprint 4: Realize Supplier-Product Association**

- **Goal**: Link suppliers with products.
- **Tasks**: 
   - Setup **supplier_product**, **supplier_brand** tables.
   - Implement logic to connect suppliers with products.

### **Sprint 5: Complete Supplier Service & Initiate Cart Service**:

- **Sprint Goal**: Establish user roles and permissions and initiate cart functionalities.
- **Tasks**: 
   1. Implement customer and user (tester) roles in user-service.
   2. Develop basic functionalities for cart-service, including saving items.

### **Sprint 6: Cart Mechanisms**:

- **Goal**: Allow **users to add products to their cart**.
- **Tasks**: 
   - Develop cart-service.
   - Features: Add to cart, view cart contents, and select items for checkout.

### **Sprint 7: Cart Service Completion & Order Service Initiation**

- **Sprint Goal**: Finalize cart functionalities and set the stage for order processing.
- **Tasks**: 
   1. Implement feature to **select items and submit to order**.
   2. Start the order-service, focusing on order creation based on cart contents.

### **Sprint 8: Ordering and Initial Payments**

- **Goal**: Convert** seletced cart items** into orders and initiate payments.
- **Tasks**: 
   - Start order-service: Setup order creation from cart.
   - Kickoff payment-service for payment initiations.

### **Sprint 9: Payment Completion & Start Coupons Service**

- **Goal**: Complete payment processes and introduce coupon mechanisms.
- **Tasks**: 
   - Finalize payment processing in payment-service.
   - Start coupon-service: Define coupon structures.

### **Sprint 10: Finalize Coupons & Testing**

- **Goal**: Complete coupon functionalities and conduct thorough testing.
- **Tasks**: 
   - Finalize coupon usage and restrictions.
   - realize the coupon messages sending mechanisms.
   - Test all services and integrations.

### Daily Activities

- **Daily Stand-up**: think about questions below before working 
   - What was done yesterday?
   - What will be done today?
   - Are there any blockers?
- **Backlog Refinement**: Regularly prioritize, update, and refine the product backlog.
- **Sprint Review**: At the end of each sprint, demonstrate the completed features to stakeholders.
- **Sprint Retro**

### End of Sprint

-  **Sprint Review**: Self proofreading as this is a personal project. Get feedback. 
-  **Sprint Retrospective**:  
   - What went well?
   - What can be improved?
   - Actions for improvements.


## 4 Wrap-up [return to outline](https://github.com/coco2023/QuickMall-eCommerce#quickmall-scrum-development-plan)

1. **Deployment**: Move the thoroughly tested backend to a production environment.
2. **Documentation**: Ensure that all services, functionalities, and endpoints are meticulously documented.
3. **Feedback Loop**: Regularly gather feedback and iterate on the product.

By the end of these sprints, the `quickmall` backend API should be ready for deployment. It's essential to note that Scrum is iterative and adaptive, so while this plan provides a roadmap, flexibility is crucial to accommodate changes and feedback.
