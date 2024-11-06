Feature: Kullanıcı giriş işlemleri

  Scenario: Kullanıcı yanlış bilgilerle giriş yapmaya çalışır en son doğru bilgileri girer
    Given Kullanıcı giriş sayfasını açar
    When Kullanıcı yanlış bir e-posta "e-posta" girer
    And Kullanıcı geçerli bir şifre "Dogru şifre" girer
    And Kullanıcı giriş butonuna tıklar
    Then Kullanıcı yanlış e-posta mesajını kontrol eder

    When Kullanıcı geçerli bir e-posta "e-posta" girer
    And Kullanıcı yanlış bir şifre "yanlış şifre" girer
    Then Kullanıcı  yanlış şifre mesajını kontrol eder

    When Kullanıcı geçerli bir e-posta "e-posta" girer ve geçerli bir şifre girer
    Then kullanıcı giriş yapar
