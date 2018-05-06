# json-custom-serializer
Example of a Json custon serializer

Run Main class and then:

curl -v -H "Content-Type: application/json" \
   -X POST http://localhost:8080/users \
   -d '{"name": "Paul", "age": 45, "gender":"male"}'

curl -v -H "Content-Type: application/json" \
   -X GET http://localhost:8080/users/Laura

