CREATE TABLE [tasks] (
  [id] bigint NOT NULL,
  [name] character varying(255) NOT NULL,
  [colour] character varying(255) NOT NULL
)
GO

CREATE TABLE [events] (
  [id] bigint NOT NULL,
  [description] character varying(255),
  [event_date] date,
  [task_id] bigint NOT NULL,
  [user_id] bigint NOT NULL
)
GO

CREATE TABLE [users] (
  [id] bigint NOT NULL,
  [active] boolean,
  [first_name] character varying(255),
  [last_name] character varying(255),
  [password] character varying(255) NOT NULL,
  [role] integer NOT NULL
)
GO

ALTER TABLE [events] ADD FOREIGN KEY ([task_id]) REFERENCES [tasks] ([id])
GO

ALTER TABLE [events] ADD FOREIGN KEY ([user_id]) REFERENCES [users] ([id])
GO
