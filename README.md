# Spring-Boot-Microservices

There are 3 microservices and Eureka Server as Service Discovery and Hystrix as Circuit Breaker

## movie-ratings-data-service :- provide rest apis to get all movies, reviews and ratings given by user.

http://localhost:11001/ratingsdata/users  --> Get all usres

http://localhost:11001/ratingsdata/users/{userId} --> Get all movies, reviews and ratings given by user

http://localhost:11001/ratingsdata/movies/{movieId} --> Get all users, who given rating and review to the given movie

## movie-info-service :- provide rest apis to get movie's details.

http://localhost:10001/movies --> Get details of all movies

http://localhost:10001/movies/{movieId} --> Get details of movie by movieId


## movie-catalog-service :- This service talk to both service and get the data from both microservices(movie-ratings-data-service & movie-info-service) and return consolidated result to the user. This service return movies info and user's rating and review for those movies which user has given rating or written review

http://localhost:9001/catalog/{userId} --> get combine result of movies details and user's rating and review about movies

## Hystrix (Circuit Breaker)
http://localhost:9001/hystrix

## Eureka Server (Service Discovery)
movie-discovery-server
http://localhost:8761/
