## README

So this is a simple repo with only two modules, example-api and example-impl.

The repo demonstrates how to use SansORM, an alternative ORM library, to access an 
external database and retrieve data from a system that SB could not be used (because 
a primary key is a double, not a long or a string).

In addition, it shows how to include and encapsulate a non-OSGi dependency that the 
implementation can use, but it doesn't leak out to the consumers of the module.

To read the accompanying blog post, navigate to [https://liferay.dev/blogs/-/blogs/osgi-service-example-using-alternate-orm](https://liferay.dev/blogs/-/blogs/osgi-service-example-using-alternate-orm).

*NOTE:* To use this example, you need to have a table defined as follows (from Postgresql):

```sql
CREATE TABLE public.doublekey (
	pkey numeric NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT doublekey_pk PRIMARY KEY (pkey)
);
```

In addition, in Postgresql I also had to issue the command `ALTER TABLE doublekey ALTER COLUMN pkey TYPE DOUBLE PRECISION;`.

To access the database, the portal-ext.properties file should have the following properties (edited for your local environment):

```properties
jdbc.testing.driverClassName=org.postgresql.Driver
jdbc.testing.url=jdbc:postgresql://192.168.1.8/Testing
jdbc.testing.username=liferay
jdbc.testing.password=lportal
```

