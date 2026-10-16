provider "aws" {
  region = "us-east-1"
}

# VULN: Public read access on S3 bucket (CKV_AWS_20)
# VULN: Missing encryption (CKV_AWS_19)
resource "aws_s3_bucket" "insecure_bucket" {
  bucket = "my-java-app-insecure-bucket-12345"
  acl    = "public-read"
}

# VULN: Security Group allows SSH from anywhere (CKV_AWS_24)
resource "aws_security_group" "allow_all_ssh" {
  name        = "allow_all_ssh"
  description = "Allow SSH inbound traffic from specific IPs"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["10.0.0.0/8", "203.0.113.0/24"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
