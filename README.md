# Spring-Boot-Microservices

There are 3 microservices

# movie-ratings-data-service :- provide rest apis to get all movies, review and rating given by user

http://localhost:11001/ratingsdata/users  --> Get all usres

http://localhost:11001/ratingsdata/users/{userId} --> Get all movies, review and rating given by user

http://localhost:11001/ratingsdata/movies/{movieId} --> Get all users, who given rating and review to the given movie

# movie-info-service :- provide rest apis to get movies dtails

http://localhost:10001/movies --> Get details of all movies

http://localhost:10001/movies/{movieId} --> Get details of movie by movieId


# movie-catalog-service :- This service talk to both service and get the data both microservices and return consolidated result to the user

http://localhost:9001/catalog/{userId} --> get combine result about movie and user's rating and review about movie

# Hystrix (Circuit breaker)
http://localhost:9001/hystrix

# Eureka server (Service Discovery)
movie-discovery-server
http://localhost:8761/
