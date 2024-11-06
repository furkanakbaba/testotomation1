Feature: Kullanıcı giriş işlemleri

  Scenario Outline: Kullanıcı yanlış bilgilerle giriş yapmaya çalışır en son doğru bilgileri girer
    Given Kullanıcı giriş sayfasını açar
    When Kullanıcı yanlış bir e-posta "<yanlış e-posta>" girer
    And Kullanıcı geçerli bir şifre "<dogru şifre>" girer
    And Kullanıcı giriş butonuna tıklar
    Then Kullanıcı yanlış e-posta mesajını kontrol eder

    When Kullanıcı geçerli bir e-posta "<dogru e-posta>" girer
    And Kullanıcı yanlış bir şifre "<yanlış şifre>" girer
    Then Kullanıcı  yanlış şifre mesajını kontrol eder

    When Kullanıcı geçerli bir e-posta "<dogru e-posta>" girer ve geçerli bir şifre "<dogru şifre>" girer
    Then kullanıcı giriş yapar
    Examples:
      |yanlış e-posta|dogru şifre|dogru e-posta|yanlış şifre|
      |furkanakbaba123321@gmail.com|472722.Aq|furkanakbabadev@gmail.com|furkanakbaba123321.a|




