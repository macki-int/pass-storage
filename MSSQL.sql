CREATE DATABASE [ps]

CREATE TABLE [[passwords] (
  [id] [uniqueidentifier] NOT NULL,
	[name] [varchar](256) NOT NULL,
	[url] [varchar](max) NULL,
	[user] [varchar](256) NULL,
	[password] [varchar](256) NULL,
	[description] [varchar](max) NULL,
	[active] [bit] NOT NULL,
	[update_date] [date] NOT NULL,
 CONSTRAINT [PK_passwords] PRIMARY KEY CLUSTERED
)