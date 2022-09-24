# psychic-pancake
this is Room Database Migration Guide

## Why do i need this?
### So the app won't have any crashes when the database schema changes, while having the old data in the old database


## How do you actually did it?
### Here's how

#### 1. With you current entity tables and room version, add 
   ![Screenshot from 2022-09-24 11-24-29](https://user-images.githubusercontent.com/91923470/192079799-557afc8f-862a-4942-b6e6-95b99d982f0b.png)
#### in order to generate you current database schema, sync gradle then run the app.

#### 2. Do the changes you want to the entity tables, but make sure you put the default value if you want to add new column using @ColumnInfo, also change the version number.
####    for example : 
   ![Screenshot from 2022-09-24 11-29-21](https://user-images.githubusercontent.com/91923470/192079943-98e2af66-f8e4-485a-8370-4bdbe61aec58.png)

#### 3. Add the automigration delcaration on your Database class, for example : 
  ![image](https://user-images.githubusercontent.com/91923470/192080107-31a38477-6f96-410c-98b6-d8d3b1b1c390.png)
#### here, i want to migrate from version 1 of my database, to version 2 of my database. run the app, and don't worry there will be a runtime error, but with that runtime error the app will generate your database schema.

#### 4. Adjust the database schema
#### After the runtime error, you'll have 2 .json files of your database schema, you can find it here : 
  ![image](https://user-images.githubusercontent.com/91923470/192080248-21ef92bb-df18-43c0-a374-4afdcbeac589.png)
#### but as if right now, the 2 of .json files will be the same, because it generates during the runtime error, so what you have to do right now?
#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; a. delete the json file for your previous version (in my case is 1.json)
#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; b. undo the changes that you do on your database schema
#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; c. revert the version back to the previous version (in my case is version = 1)
#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; d. run the app, and that will generate the actual database schema for your previous database version

#### 5. Re-do the changes you made 
#### results : 
 ![image](https://user-images.githubusercontent.com/91923470/192080756-b9a5c0f3-ffd5-4517-830c-1f97cab3ba01.png)
#### the top one is the old data, the bottom one is the new data. And there you go, now there are new column called "age" and the default value is 0
#### now i know, this isn't the most efficient way to do migration, but this works for me. And if you found the better way of doing this, i hope you willing to share it with me
#### And that's pretty much it for the migration, i hope this helps


## with love, Sendiko
