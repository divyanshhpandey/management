resource "aws_s3_bucket" "insecure_bucket" {
  bucket = "my-java-app-insecure-bucket-12345"
  acl    = "private"
}
}
