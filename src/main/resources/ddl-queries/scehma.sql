CREATE TABLE bitcoin_price_index(
    id INT AUTO_INCREMENT PRIMARY KEY,
    disclaimer VARCHAR(225),
    chartName VARCHAR(255),
    updated TIMESTAMP,
);

CREATE TABLE bpi_rates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bpi_id INT
    code VARCHAR(225),
    symbol VARCHAR(255),
    rate_str VARCHAR(255),
    description VARCHAR(255),
    rate DECIMAL,
    CONSTRAINT fk_customer_id FOREIGN KEY (bpi_id) REFERENCES bitcoin_price_index(id)
);


{
  "time": {
    "updated": "May 31, 2024 20:32:23 UTC",
    "updatedISO": "2024-05-31T20:32:23+00:00",
    "updateduk": "May 31, 2024 at 21:32 BST"
  },
  "disclaimer": "This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org",
  "chartName": "Bitcoin",
  "bpi": {
    "USD": {
      "code": "USD",
      "symbol": "&#36;",
      "rate": "67,656.312",
      "description": "United States Dollar",
      "rate_float": 67656.3123
    },