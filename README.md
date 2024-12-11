API Endpoints

1. Start a Quiz Session

Endpoint: POST `/api/quiz/start`

Description: Starts a new quiz session.

Response:

```
{
  "id": 1,
  "answeredQuestions": [],
  "correctAnswers": 0,
  "incorrectAnswers": 0
}
```

2. Get a Random Question

Endpoint: GET `/api/quiz/question`

Parameters:

sessionId (required): ID of the active quiz session.

Response:

```
{
  "id": 1,
  "text": "What is the capital of France?",
  "optionA": "Paris",
  "optionB": "Berlin",
  "optionC": "Madrid",
  "optionD": "Rome"
}
```

3. Submit an Answer

Endpoint: POST `/api/quiz/submit`

Parameters:

sessionId (required): ID of the active quiz session.

questionId (required): ID of the question being answered.

answer (required): Selected option (e.g., "A").

Response:

```Answer submitted successfully```

4. View Quiz Summary

Endpoint: GET `/api/quiz/summary`

Parameters:

sessionId (required): ID of the active quiz session.

Response:
```
{
  "id": 1,
  "answeredQuestions": [1, 2],
  "correctAnswers": 1,
  "incorrectAnswers": 1
}
```
