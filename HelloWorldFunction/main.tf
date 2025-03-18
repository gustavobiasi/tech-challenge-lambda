resource "aws_lambda_function" "lambda-autenticacao" {
  function_name = "lambda-autenticacao"
  handler       = "helloworld.App::handleRequest"
  runtime       = "java17"
  role          = "arn:aws:iam::141234920247:role/LabRole"

  filename         = "target/LambdaAutenticacao-1.0.jar"
  source_code_hash = filebase64sha256("target/LambdaAutenticacao-1.0.jar")
  timeout = 15
}