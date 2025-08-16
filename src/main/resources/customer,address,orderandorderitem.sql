-- Drop tables if they exist (must be in FK order)
DROP TABLE order_item CASCADE CONSTRAINTS;
DROP TABLE orders CASCADE CONSTRAINTS;
DROP TABLE customer CASCADE CONSTRAINTS;
DROP TABLE address CASCADE CONSTRAINTS;

-- Create table: address
CREATE TABLE address (
  id NUMBER(5) PRIMARY KEY,
  city VARCHAR2(255),
  country VARCHAR2(255),
  state VARCHAR2(255),
  street VARCHAR2(255),
  zip_code VARCHAR2(255)
);

-- Create table: customer
CREATE TABLE customer (
  id NUMBER(5) PRIMARY KEY,
  first_name VARCHAR2(255),
  last_name VARCHAR2(255),
  email VARCHAR2(255)
);

-- Create table: orders
CREATE TABLE orders (
  id NUMBER(5) PRIMARY KEY,
  order_tracking_number VARCHAR2(255),
  total_price NUMBER(19,2),
  total_quantity NUMBER,
  billing_address_id NUMBER,
  customer_id NUMBER,
  shipping_address_id NUMBER,
  status VARCHAR2(128),
  date_created TIMESTAMP,
  last_updated TIMESTAMP,
  CONSTRAINT fk_orders_customer FOREIGN KEY (customer_id) REFERENCES customer(id),
  CONSTRAINT fk_orders_billing_address FOREIGN KEY (billing_address_id) REFERENCES address(id),
  CONSTRAINT fk_orders_shipping_address FOREIGN KEY (shipping_address_id) REFERENCES address(id),
  CONSTRAINT uq_billing_address UNIQUE (billing_address_id),
  CONSTRAINT uq_shipping_address UNIQUE (shipping_address_id)
);

-- Create table: order_item
CREATE TABLE order_item (
  id NUMBER(5) PRIMARY KEY,
  image_url VARCHAR2(255),
  quantity NUMBER,
  unit_price NUMBER(19,2),
  order_id NUMBER,
  product_id NUMBER,
  CONSTRAINT fk_order_item_order FOREIGN KEY (order_id) REFERENCES orders(id),
  CONSTRAINT fk_order_item_product FOREIGN KEY (product_id) REFERENCES product(id)
);

-- Create sequences
CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE address_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE orders_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE order_item_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
