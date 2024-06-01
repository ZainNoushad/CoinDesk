CREATE TABLE bitcoin_price_index(
    id INT AUTO_INCREMENT PRIMARY KEY,
    disclaimer VARCHAR(225),
    chart_name VARCHAR(255),
    updated DATETIME
);

CREATE TABLE bpi_rates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bpi_id INT,
    code VARCHAR(225),
    symbol VARCHAR(255),
    rate_str VARCHAR(255),
    description VARCHAR(255),
    rate DECIMAL(15,5),
    CONSTRAINT fk_customer_id FOREIGN KEY (bpi_id) REFERENCES bitcoin_price_index(id)
);