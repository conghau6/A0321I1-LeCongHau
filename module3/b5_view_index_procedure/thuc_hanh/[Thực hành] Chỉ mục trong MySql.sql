alter table customers add index idx_full_name(contactFirstName, contactLastName);
ALTER TABLE customers DROP INDEX idx_full_name;