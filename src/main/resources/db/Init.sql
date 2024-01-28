INSERT INTO `qp-assessment`.`roles` (`role`) VALUES ('ADMIN');

INSERT INTO `qp-assessment`.`roles` (`role`) VALUES ('USER');

INSERT INTO `qp-assessment`.`users` (`email`, `mobile_number`, `name`, `password`, `role_id`) VALUES ('admin@gmail.com', '7875351454', 'Test Admin', '$2a$10$1Z.ZLxy7nCHyo0f1bZyzSO2xkksdUZhfe2wf.tHZCZu8CR0p14yLa', '1');

INSERT INTO `qp-assessment`.`users` (`email`, `mobile_number`, `name`, `password`, `role_id`) VALUES ('user@gmail.com', '8858553366', 'Test User', '$2a$10$1Z.ZLxy7nCHyo0f1bZyzSO2xkksdUZhfe2wf.tHZCZu8CR0p14yLa', '2');