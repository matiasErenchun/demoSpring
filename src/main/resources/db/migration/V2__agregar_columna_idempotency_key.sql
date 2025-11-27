ALTER TABLE greeting_request
ADD COLUMN idempotency_key UUID NOT NULL UNIQUE;
