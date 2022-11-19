Feature: CRUD of/posts endpoint

  Background:
    Given User creates a new user


    Scenario Outline: Create a post in a /posts endpoint
      When User creates a post with title "<title>" and body "<body>"
      Then Check if post is created with title "<title>" and body "<body>"

      Examples:
      |title|body|
      |this is a title|this is a body|





