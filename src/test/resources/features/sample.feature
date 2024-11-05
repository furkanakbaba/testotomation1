Feature: Karaca Uygulaması Test Senaryosu

  Scenario: Ürün sepete ekleme ve alışverişi tamamlama
    Given Kullanıcı Karaca uygulamasını açar
    When Kullanıcı rastgele bir kategori ve alt kategori seçer
    And Kullanıcı "50-100 TL"  fiyat aralığını seçer
    And Kullanıcı Çok Değerlendirilenler seçeneğini seçer
    And Kullanıcı ilk ürünü sepete ekler
    And Kullanıcı sepete gider ve ürün miktarını artırır
    Then Kullanıcı ürün fiyatını kontrol eder
    And Kullanıcı Alışverişi Tamamla butonuna tıklar