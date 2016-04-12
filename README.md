### Aircraftcarriers Android App README

Code for Aircraftcarriers android application.  

Other repositories found nearby provide this data in other ways:

1. Via the web inside of a PHP Laravel framework and MySQL database running on apache on linux. [https://github.com/botanyhelp/Laravelcarriers](https://github.com/botanyhelp/Laravelcarriers)
2. Via the web running on Ruby on Rails and Postgres running at Heroku [https://github.com/botanyhelp/Herokucarriers](https://github.com/botanyhelp/Herokucarriers)


Creation of the properly sized PNG image files for use in the android app was done with ImageMagick convert as shown here:
```{bash}
convert -resize 36x36 aircraftcarriers3.png   aircraftcarriers36.png;
convert -resize 48x48 aircraftcarriers3.png   aircraftcarriers48.png;
convert -resize 72x72 aircraftcarriers3.png   aircraftcarriers72.png;
convert -resize 96x96 aircraftcarriers3.png   aircraftcarriers96.png;
convert -resize 144x144 aircraftcarriers3.png   aircraftcarriers144.png;

mkdir aircraftcarriers336
mkdir aircraftcarriers348
mkdir aircraftcarriers364
mkdir aircraftcarriers372
mkdir aircraftcarriers396
mkdir aircraftcarriers3144

cp aircraftcarriers36.png ./aircraftcarriers336/aircraftcarriers.png
cp aircraftcarriers48.png ./aircraftcarriers348/aircraftcarriers.png
cp aircraftcarriers64.png ./aircraftcarriers364/aircraftcarriers.png
cp aircraftcarriers72.png ./aircraftcarriers372/aircraftcarriers.png
cp aircraftcarriers96.png ./aircraftcarriers396/aircraftcarriers.png
cp aircraftcarriers144.png ./aircraftcarriers3144/aircraftcarriers.png
```
These XML lines in explain the location of some images for use as buttons in the app:
```{xml}
                android:src="@drawable/brazilian"
                android:src="@drawable/argentine"
                android:src="@drawable/french"
                android:src="@drawable/indian"
                android:src="@drawable/japanese"
                android:src="@drawable/koninklijke"
                android:src="@drawable/kriegsmarine"
                android:src="@drawable/marinamilitare"
                android:src="@drawable/pla"
                android:src="@drawable/thai"
                android:src="@drawable/russian"
                android:src="@drawable/spanish"
                android:src="@drawable/swedish"
                android:src="@drawable/uk"
                android:src="@drawable/us"
```
And the corresponding strings:
```{xml}
    <string name="aircraftcarriersbutton">aircraftcarriersbutton</string>
    <string name="brazilian">brazilian</string>
    <string name="argentine">argentine</string>
    <string name="french">french</string>
    <string name="indian">indian</string>
    <string name="japanese">japanese</string>
    <string name="koninklijke">koninklijke</string>
    <string name="kriegsmarine">kriegsmarine</string>
    <string name="marinamilitare">marinamilitare</string>
    <string name="pla">pla</string>
    <string name="thai">thai</string>
    <string name="russian">russian</string>
    <string name="spanish">spanish</string>
    <string name="swedish">swedish</string>
    <string name="uk">uk</string>
    <string name="us">us</string>
```
These values allow the code to use the string "swedish" to grab the associated text "swedish" and the image "swedish.png".  Because we have 472 images and because they are large and apps are limited to 50MB, we only store one "medium" sized copy of carrier images:
```{bash}
ls res/drawable-mdpi/|wc -l
472
ls res/drawable-ldpi/|wc -l
1
ls res/drawable-ldpi/
aircraftcarriers.png
```
The medium sized PNG will be served on every phone and tablet no matter its physical composition.  The large aircraftcarriers.png is the appilcation icon which allows the buttons to be available for every sized phone.  We created that as shown above with ImageMagick convert. 

At the heart of this application (like the Heroku RoR app and the Laravel PHP app) is an SQL database.  On android, that is an SQLite3 database that was created like this:
```{bash}
sqlite3 ../../carriersMISC/carrier
SQLite version 3.7.13 2012-06-11 02:05:22
Enter ".help" for instructions
Enter SQL statements terminated with a ";"
sqlite> .schema
CREATE TABLE carrier (carriername text default null, carrierdata text default null);
CREATE INDEX idxcarrierdata ON carrier(carrierdata);
CREATE INDEX idxcarriername ON carrier(carriername);
```
Also used during construction was another database.  This database is not inside of the application.  Creating an SQLite database from slurps of wikipedia pages can be tedious.  In particular, getting all of the data correctly into its proper column must overcome lots of strange characters that can show up in HTML slurps.  Using sed and friends helps but the sqlite database that resides inside of an android application should be properly aligned.  Otherwise there will be missing records or records where the **servicePeriod** data is in the **pennant** column.  More data cleaning could have overcome these difficulties.  Instead, we stuffed the name of the carrier into the **carriername** column and the whole rest into the **carrierdata** column.  Even so, this more complex database was created to manually assemble the logical groups of carriers.  For example, this allows us to get all of the carriers in a **class** or **type** or carriers from a specific **service** or **servicePeriod**.  These groupings are evident during the operation of the application.  Users can choose to see only carriers in the US Navy, for example.  Those groupings were produced by querying this more complex database and were manually placed into the application.  That databse schema has more columns and was constructed like this:
```{sql}
CREATE TABLE carrier (name text default null, service text default null, pennant text default null, class text default null, type text default null, servicePeriod text default null, notes text default null);

.read carriers.txt.sql

CREATE INDEX idxname ON carrier(name);
CREATE INDEX idxservice ON carrier(service);
CREATE INDEX idxpennant ON carrier(pennant);
CREATE INDEX idxclass ON carrier(class);
CREATE INDEX idxtype ON carrier(type);
CREATE INDEX idxservicePeriod ON carrier(servicePeriod);
CREATE INDEX idxnotes ON carrier(notes);
```
The **.read** line is an sqlite command to read in that file.  That file creates 472 records:
```{bash}
cat ../carriersMISC/carriers.txt.sql|wc -l
448
``` 
Its lines are SQL INSERT statements consistent with the schema shown above.  Lines look like these actual lines:
```{sql}
INSERT INTO carrier (name,service,pennant,class,type,servicePeriod,notes) VALUES ('USS Yorktown',' US Navy','CV-10','Essex','Fleet Carrier','1943–1970','Museum at Mount Pleasant, SC');
INSERT INTO carrier (name,service,pennant,class,type,servicePeriod,notes) VALUES ('Zuihō',' IJN','','Zuihō','Light Carrier','1940–1944','Converted high-speed oiler Takasaki, sunk by aircraft at Leyte Gulf 25 October 1944');
INSERT INTO carrier (name,service,pennant,class,type,servicePeriod,notes) VALUES ('Zuikaku',' IJN','','Shōkaku','Fleet Carrier','1941–1944','Sunk by aircraft at Leyte Gulf 25 October 1944');
``` 
Notice that after these lines are inserted we create an index on every column.  This was done with both databases.  Because this database is read only, these indexes won't change after the initial **CREATE INDEX** statement.  They speed up the querying such that other app things are slower than the query itself.  Without these index the query time gets to be noticeable even on this little database.  With these indexes in place, we can query however and whatever we like without thinking of database performance.  The interface of the application and the types of queries we provide become the central focus.  In DBAdapter.java we see these lines:
```{java}
String selection;
selection = "carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ? AND carrierdata LIKE ?";
String[] selectionArgs = new String[] { carrierdataParam, carrierdataParamtwo, carrierdataParamthree, carrierdataParamfour, carrierdataParamfive};
}
```
The second line above is SQL and we are allowing to search the database for five different strings entered by the user.  Because the "notes" column houses lots of data (the text contents of almost an entire wikipedia page) searching for lots of terms might be convenient in some cases.  Because each column of the database has and index, these queries will finish almost immediately.  The application interface can allow a query like this one, actually performed in sqlite3 on linux:
```{bash}
sqlite> SELECT carriername FROM carrier WHERE carrierdata LIKE "%Wake Island%" AND carrierdata LIKE "%sank%"  AND carrierdata LIKE "%1944%"  AND carrierdata LIKE "%Pearl Harbor%" AND carrierdata LIKE "%Fiske%";
USS_Wake_Island_CVE65
```
Almost all of the data, text and images in this app are kindly written and created by and shared by wikipedia authors under the license shown here:
[https://en.wikipedia.org/wiki/Wikipedia:Text_of_Creative_Commons_Attribution-ShareAlike_3.0_Unported_License](https://en.wikipedia.org/wiki/Wikipedia:Text_of_Creative_Commons_Attribution-ShareAlike_3.0_Unported_License)
