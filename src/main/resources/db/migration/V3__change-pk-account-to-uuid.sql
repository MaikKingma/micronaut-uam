ALTER TABLE account DROP CONSTRAINT account_pkey;
ALTER TABLE account ADD COLUMN id UUID;
ALTER TABLE account ADD PRIMARY KEY (id);