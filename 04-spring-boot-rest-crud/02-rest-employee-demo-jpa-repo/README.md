# What I learned

instead of relying on Dao interface & implemenation, we can minimize all this bolier-plate code with `Spring-Data-JPA`
which supports the default CRUD methods for you for FREE without you having to write any code, and you can extend it with your custom queries

using for example `@Query("your query here")` annotation