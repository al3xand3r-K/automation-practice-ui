# UI Tests Dummy Project

A bunch of dummy UI tests to try out method chaining and data serialization.
Tests are run against [automationpractice.com](http://automationpractice.com) - a dummy webstore.

## Stack

- Gradle (wrapper v.4.8)
- TestNG
- Selenide
- Lombok
- [Webdriver-Manager](https://github.com/bonigarcia/webdrivermanager)
- Allure 2

## Running Tests

Run tests:

```
make test
```

Build and open report:

```
make report
```

## Troubleshooting

Enabling Lombok support for IntelliJ IDEA users:

1. Open settings `ctrl + alt + s`
2. Nav to `Build, Execution, Deployment` > `Compiler` > `Annotation Processors`
3. Check `Enable annotation processing` checkbox
4. Install `Lombok Plugin`
5. Restart IDE