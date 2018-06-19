# Flight Booking API Application

SpringBoot Application that demonstrates REST API Development using Spring MVC, Spring Data JPA using Java 8 features

## Features

This application has two primary REST end-points that provide flight-booking information. 

1. GET /bookings?uid={passenger-id}
2. GET /bookings/{booking-id}

Besides these two primary end-points, there are few other end-points to support the consumer apps(mobile/web). They are:
1. GET /airports
2. GET /airports/{iata-code}
3. GET /flights
4. GET /flights/{flight-id}
5. GET /passengers
6. GET /passengers/{passenger-id}

To test these end-points, see the API documentation section [here](#API-Documentation-and-Integration-Testing)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
1. Java 8
2. Maven 3

[API Documentation (Swagger)]


### Installing & Running

- Clone this repo to your local: 
	
    git clone https://sameerean@bitbucket.org/sameerean/flight-booking.git

-  Build using maven 

	mvn clean install
- Start the app

	mvn spring-boot:run
- Test the URLs

    1. [http://localhost:8080/bookings?uid=PS-10](http://localhost:8080/bookings?uid=PS-10)
    12. [http://localhost:8080/bookings/FB-10](http://localhost:8080/bookings/FB-10)

### API Documentation and Integration Testing

API documentation can be accessed via [Swagger UI](http://localhost:8080/swagger-ui.html) 



Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
