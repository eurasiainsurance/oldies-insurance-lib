-- MIGRATION SCRIPT FROM 1.8 TO 1.9

-- policy vehicle forced major city
ALTER TABLE POLICY_VEHICLE ADD COLUMN FORCED_MAJOR_CITY TINYINT(1) default 0 AFTER ID;

-- callback requests
CREATE TABLE CALLBACK_REQUEST (ID INTEGER NOT NULL, COMMENTS VARCHAR(255), PRIMARY KEY (ID));
ALTER TABLE CALLBACK_REQUEST ADD CONSTRAINT FK_CALLBACK_REQUEST_ID FOREIGN KEY (ID) REFERENCES REQUEST (ID);


-- phone number is not PK
ALTER TABLE POS_CONTACT_PHONE
	DROP PRIMARY KEY,
	MODIFY COLUMN PHONE_NUMBER VARCHAR(255) AFTER PHONE_COUNTRY_CODE,
	MODIFY COLUMN PHONE_AREA_CODE VARCHAR(255),
	MODIFY COLUMN PHONE_COUNTRY_CODE VARCHAR(255),
	ADD COLUMN ID INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL FIRST;

-- request source
ALTER TABLE REQUEST
	ADD COLUMN CREATED_BY_USER_ID INTEGER AFTER COMPLETED_BY_USER_ID,
	ADD CONSTRAINT FK_REQUEST_CREATED_BY_USER_ID FOREIGN KEY (CREATED_BY_USER_ID) REFERENCES USER (ID);

/*
 * VERSION TABLE
 */
DROP TABLE VER_1_8;
CREATE TABLE VER_1_9 (DUMMY INTEGER NOT NULL, PRIMARY KEY (DUMMY));