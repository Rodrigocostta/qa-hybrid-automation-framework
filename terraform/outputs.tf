output "file_created" {

  description = "Arquivo criado pelo Terraform"

  value = local_file.test_report_config.filename

}