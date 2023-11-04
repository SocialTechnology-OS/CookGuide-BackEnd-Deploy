-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-11-04 12:22:55.158

-- tables
-- Table: accounts
CREATE TABLE accounts (
    uid int  NOT NULL,
    firstName varchar(100)  NOT NULL,
    lastName varchar(100)  NOT NULL,
    userType boolean  NOT NULL,
    healthId int  NOT NULL,
    preferencesId int  NOT NULL,
    userEmail varchar(100)  NOT NULL,
    userPassword varchar(100)  NOT NULL,
    dni int  NOT NULL,
    birthday date  NOT NULL,
    CONSTRAINT accounts_pk PRIMARY KEY (uid)
);

-- Table: health_info
CREATE TABLE health_info (
    uid int  NOT NULL,
    imc int  NOT NULL,
    weight decimal(5,2)  NOT NULL,
    height decimal(5,2)  NOT NULL,
    CONSTRAINT health_info_pk PRIMARY KEY (uid)
);

-- Table: ingredients
CREATE TABLE ingredients (
    uid int  NOT NULL,
    name varchar(200)  NOT NULL,
    otherNames json  NOT NULL,
    vitamins json  NOT NULL,
    description text  NOT NULL,
    CONSTRAINT ingredients_pk PRIMARY KEY (uid)
);

-- Table: log_ingredients
CREATE TABLE log_ingredients (
    recipesId int  NOT NULL,
    ingredientsId int  NOT NULL,
    quantity int  NOT NULL,
    size varchar(15)  NOT NULL,
    CONSTRAINT log_ingredients_pk PRIMARY KEY (recipesId)
);

-- Table: preferences
CREATE TABLE preferences (
    uid int  NOT NULL,
    feeding varchar(100)  NOT NULL,
    tastes json  NOT NULL,
    allerges json  NOT NULL,
    needs json  NOT NULL,
    CONSTRAINT preferences_pk PRIMARY KEY (uid)
);

-- Table: recipes
CREATE TABLE recipes (
    uid int  NOT NULL,
    category varchar(50)  NOT NULL,
    numPortions int  NOT NULL,
    description text  NOT NULL,
    CONSTRAINT recipes_pk PRIMARY KEY (uid)
);

-- Table: recipes_saved
CREATE TABLE recipes_saved (
    accountsId int  NOT NULL,
    recipesId int  NOT NULL,
    CONSTRAINT recipes_saved_pk PRIMARY KEY (accountsId,recipesId)
);

-- Table: transactions
CREATE TABLE transactions (
    accountsId int  NOT NULL,
    uid int  NOT NULL,
    CONSTRAINT transactions_pk PRIMARY KEY (uid)
);

-- foreign keys
-- Reference: Table_9_Table_10 (table: log_ingredients)
ALTER TABLE log_ingredients ADD CONSTRAINT Table_9_Table_10
    FOREIGN KEY (ingredientsId)
    REFERENCES ingredients (uid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Table_9_recipes (table: log_ingredients)
ALTER TABLE log_ingredients ADD CONSTRAINT Table_9_recipes
    FOREIGN KEY (recipesId)
    REFERENCES recipes (uid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: accounts_health_info (table: accounts)
ALTER TABLE accounts ADD CONSTRAINT accounts_health_info
    FOREIGN KEY (healthId)
    REFERENCES health_info (uid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: accounts_preferences (table: accounts)
ALTER TABLE accounts ADD CONSTRAINT accounts_preferences
    FOREIGN KEY (preferencesId)
    REFERENCES preferences (uid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: log_recipes_accounts (table: recipes_saved)
ALTER TABLE recipes_saved ADD CONSTRAINT log_recipes_accounts
    FOREIGN KEY (accountsId)
    REFERENCES accounts (uid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: log_recipes_recipes (table: recipes_saved)
ALTER TABLE recipes_saved ADD CONSTRAINT log_recipes_recipes
    FOREIGN KEY (recipesId)
    REFERENCES recipes (uid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: transactions_accounts (table: transactions)
ALTER TABLE transactions ADD CONSTRAINT transactions_accounts
    FOREIGN KEY (accountsId)
    REFERENCES accounts (uid)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

