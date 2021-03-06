USE [DFAP]
GO
/****** Object:  Table [dbo].[article]    Script Date: 08.10.2018 15:00:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[article](
	[id_article] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[description] [varchar](50) NULL,
 CONSTRAINT [PK_article] PRIMARY KEY CLUSTERED 
(
	[id_article] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[feedback_entry]    Script Date: 08.10.2018 15:00:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[feedback_entry](
	[feedback_entry_id] [bigint] IDENTITY(1,1) NOT NULL,
	[ordering_id] [bigint] NULL,
	[sub_process_id] [int] NULL,
	[accepted] [real] NULL,
	[rejected] [real] NULL,
	[weight] [real] NULL,
	[speed] [real] NULL,
	[start_time] [datetime2](7) NULL,
	[end_time] [datetime2](7) NULL,
	[shift] [int] NULL,
	[employee_number] [int] NULL,
 CONSTRAINT [PK_feedback_entry] PRIMARY KEY CLUSTERED 
(
	[feedback_entry_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[machine]    Script Date: 08.10.2018 15:00:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[machine](
	[machine_id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[printerAddress] [nvarchar](16) NULL,
 CONSTRAINT [PK_machine] PRIMARY KEY CLUSTERED 
(
	[machine_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[machine_part]    Script Date: 08.10.2018 15:00:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[machine_part](
	[machine_part_id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_machine_part] PRIMARY KEY CLUSTERED 
(
	[machine_part_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[machine_property]    Script Date: 08.10.2018 15:00:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[machine_property](
	[machine_property_id] [bigint] IDENTITY(1,1) NOT NULL,
	[machine_id] [bigint] NULL,
	[machine_part_id] [bigint] NULL,
	[property_id] [bigint] NULL,
 CONSTRAINT [PK_machine_property] PRIMARY KEY CLUSTERED 
(
	[machine_property_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ordering]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ordering](
	[ordering_id] [bigint] NOT NULL,
	[article_id] [bigint] NULL,
	[tool_id] [bigint] NULL,
	[machine_id] [bigint] NULL,
	[date] [datetime2](7) NULL,
	[snr] [int] NULL,
	[total_quantity] [float] NULL,
	[total_quantity_unit] [int] NULL,
	[type_of_container] [nchar](1) NULL,
	[quantity_per_container] [float] NULL,
	[pieces_per_container] [int] NULL,
	[quantity_of_container] [float] NULL,
	[shortage] [float] NULL,
	[length_of_article] [int] NULL,
	[print_description] [varchar](200) NULL,
	[profile_body] [varchar](50) NULL,
	[profile_gasket] [varchar](50) NULL,
	[profile_gasket_quantity] [int] NULL,
	[schufo_o] [varchar](15) NULL,
	[schufo_u] [varchar](15) NULL,
	[finished_quantity] [float] NULL,
	[order_active] [int] NULL,
	[order_finished] [tinyint] NULL,
 CONSTRAINT [PK_order] PRIMARY KEY CLUSTERED 
(
	[ordering_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ordering_parts_list]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ordering_parts_list](
	[ordering_parts_list_id] [bigint] IDENTITY(1,1) NOT NULL,
	[ordering_id] [bigint] NULL,
	[component] [varchar](20) NULL,
	[description] [varchar](50) NULL,
	[quantity] [float] NULL,
	[unit] [varchar](5) NULL,
 CONSTRAINT [PK_ordering_parts_list] PRIMARY KEY CLUSTERED 
(
	[ordering_parts_list_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[process]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[process](
	[process_id] [bigint] IDENTITY(1,1) NOT NULL,
	[ordering_id] [bigint] NULL,
	[start_time] [datetime2](7) NULL,
	[end_time] [datetime2](7) NULL,
 CONSTRAINT [PK_process] PRIMARY KEY CLUSTERED 
(
	[process_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[property]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[property](
	[property_id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[type] [smallint] NOT NULL,
	[position] [int] NOT NULL,
	[property_category_id] [bigint] NULL,
 CONSTRAINT [PK_property] PRIMARY KEY CLUSTERED 
(
	[property_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[property_category]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[property_category](
	[property_category_id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
 CONSTRAINT [PK_property_category] PRIMARY KEY CLUSTERED 
(
	[property_category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[setting_value]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[setting_value](
	[setting_value_id] [bigint] IDENTITY(1,1) NOT NULL,
	[tool_setting_id] [bigint] NULL,
	[property_id] [bigint] NULL,
	[machine_part_id] [bigint] NULL,
	[value] [varchar](10) NULL,
 CONSTRAINT [PK_setting_value] PRIMARY KEY CLUSTERED 
(
	[setting_value_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sub_process]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sub_process](
	[sub_process_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[abbreviation] [varchar](5) NULL,
 CONSTRAINT [PK_procedure] PRIMARY KEY CLUSTERED 
(
	[sub_process_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[test_instruction]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[test_instruction](
	[test_instruction_id] [bigint] IDENTITY(1,1) NOT NULL,
	[date] [datetime2](7) NULL,
	[name] [nvarchar](50) NULL,
 CONSTRAINT [PK_test_instruction] PRIMARY KEY CLUSTERED 
(
	[test_instruction_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[test_instruction_entry]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[test_instruction_entry](
	[test_instruction_entry_id] [bigint] IDENTITY(1,1) NOT NULL,
	[test_instruction_id] [bigint] NULL,
	[tool_id] [bigint] NULL,
	[date] [datetime2](7) NULL,
 CONSTRAINT [PK_test_instruction_entry] PRIMARY KEY CLUSTERED 
(
	[test_instruction_entry_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[test_instruction_property]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[test_instruction_property](
	[test_instruction_property_id] [bigint] IDENTITY(1,1) NOT NULL,
	[test_instruction_id] [bigint] NOT NULL,
	[number] [int] NULL,
	[name] [nvarchar](50) NULL,
	[additional_info] [nvarchar](50) NULL,
	[type] [tinyint] NULL,
	[active] [tinyint] NULL,
 CONSTRAINT [PK_test_instruction_property] PRIMARY KEY CLUSTERED 
(
	[test_instruction_property_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[test_instruction_value]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[test_instruction_value](
	[test_instruction_value_id] [bigint] IDENTITY(1,1) NOT NULL,
	[test_instruction_entry_id] [bigint] NULL,
	[number] [int] NULL,
	[check_value] [tinyint] NULL,
	[check_text] [varchar](50) NULL,
 CONSTRAINT [PK_test_instruction_value] PRIMARY KEY CLUSTERED 
(
	[test_instruction_value_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tool]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tool](
	[tool_id] [bigint] IDENTITY(1,1) NOT NULL,
	[geometry] [nvarchar](10) NOT NULL,
	[variant] [nvarchar](10) NOT NULL,
	[version] [nvarchar](10) NULL,
	[test_instruction_id] [bigint] NULL,
 CONSTRAINT [PK_tool] PRIMARY KEY CLUSTERED 
(
	[tool_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tool_setting]    Script Date: 08.10.2018 15:00:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tool_setting](
	[tool_setting_id] [bigint] IDENTITY(1,1) NOT NULL,
	[tool_id] [bigint] NOT NULL,
	[machine_id] [bigint] NOT NULL,
	[article_id] [bigint] NULL,
	[date] [datetime2](7) NOT NULL,
	[note] [nvarchar](250) NULL,
	[ontop] [int] NULL,
 CONSTRAINT [PK_tool_setting] PRIMARY KEY CLUSTERED 
(
	[tool_setting_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[feedback_entry]  WITH CHECK ADD  CONSTRAINT [FK_feedback_entry_ordering] FOREIGN KEY([ordering_id])
REFERENCES [dbo].[ordering] ([ordering_id])
GO
ALTER TABLE [dbo].[feedback_entry] CHECK CONSTRAINT [FK_feedback_entry_ordering]
GO
ALTER TABLE [dbo].[feedback_entry]  WITH CHECK ADD  CONSTRAINT [FK_feedback_entry_sub_process] FOREIGN KEY([sub_process_id])
REFERENCES [dbo].[sub_process] ([sub_process_id])
GO
ALTER TABLE [dbo].[feedback_entry] CHECK CONSTRAINT [FK_feedback_entry_sub_process]
GO
ALTER TABLE [dbo].[machine_property]  WITH CHECK ADD  CONSTRAINT [FK_machine_property_machine] FOREIGN KEY([machine_id])
REFERENCES [dbo].[machine] ([machine_id])
GO
ALTER TABLE [dbo].[machine_property] CHECK CONSTRAINT [FK_machine_property_machine]
GO
ALTER TABLE [dbo].[machine_property]  WITH CHECK ADD  CONSTRAINT [FK_machine_property_machine_part] FOREIGN KEY([machine_part_id])
REFERENCES [dbo].[machine_part] ([machine_part_id])
GO
ALTER TABLE [dbo].[machine_property] CHECK CONSTRAINT [FK_machine_property_machine_part]
GO
ALTER TABLE [dbo].[machine_property]  WITH CHECK ADD  CONSTRAINT [FK_machine_property_property] FOREIGN KEY([property_id])
REFERENCES [dbo].[property] ([property_id])
GO
ALTER TABLE [dbo].[machine_property] CHECK CONSTRAINT [FK_machine_property_property]
GO
ALTER TABLE [dbo].[ordering]  WITH CHECK ADD  CONSTRAINT [FK_ordering_article] FOREIGN KEY([article_id])
REFERENCES [dbo].[article] ([id_article])
GO
ALTER TABLE [dbo].[ordering] CHECK CONSTRAINT [FK_ordering_article]
GO
ALTER TABLE [dbo].[ordering]  WITH CHECK ADD  CONSTRAINT [FK_ordering_machine] FOREIGN KEY([machine_id])
REFERENCES [dbo].[machine] ([machine_id])
GO
ALTER TABLE [dbo].[ordering] CHECK CONSTRAINT [FK_ordering_machine]
GO
ALTER TABLE [dbo].[ordering]  WITH CHECK ADD  CONSTRAINT [FK_ordering_tool] FOREIGN KEY([tool_id])
REFERENCES [dbo].[tool] ([tool_id])
GO
ALTER TABLE [dbo].[ordering] CHECK CONSTRAINT [FK_ordering_tool]
GO
ALTER TABLE [dbo].[ordering_parts_list]  WITH CHECK ADD  CONSTRAINT [FK_ordering_parts_list_ordering] FOREIGN KEY([ordering_id])
REFERENCES [dbo].[ordering] ([ordering_id])
GO
ALTER TABLE [dbo].[ordering_parts_list] CHECK CONSTRAINT [FK_ordering_parts_list_ordering]
GO
ALTER TABLE [dbo].[process]  WITH CHECK ADD  CONSTRAINT [FK_process_order] FOREIGN KEY([ordering_id])
REFERENCES [dbo].[ordering] ([ordering_id])
GO
ALTER TABLE [dbo].[process] CHECK CONSTRAINT [FK_process_order]
GO
ALTER TABLE [dbo].[property]  WITH CHECK ADD  CONSTRAINT [FK_property_property_category] FOREIGN KEY([property_category_id])
REFERENCES [dbo].[property_category] ([property_category_id])
GO
ALTER TABLE [dbo].[property] CHECK CONSTRAINT [FK_property_property_category]
GO
ALTER TABLE [dbo].[setting_value]  WITH CHECK ADD  CONSTRAINT [FK_setting_value_machine_part] FOREIGN KEY([machine_part_id])
REFERENCES [dbo].[machine_part] ([machine_part_id])
GO
ALTER TABLE [dbo].[setting_value] CHECK CONSTRAINT [FK_setting_value_machine_part]
GO
ALTER TABLE [dbo].[setting_value]  WITH CHECK ADD  CONSTRAINT [FK_setting_value_property] FOREIGN KEY([property_id])
REFERENCES [dbo].[property] ([property_id])
GO
ALTER TABLE [dbo].[setting_value] CHECK CONSTRAINT [FK_setting_value_property]
GO
ALTER TABLE [dbo].[setting_value]  WITH CHECK ADD  CONSTRAINT [FK_setting_value_setting_value] FOREIGN KEY([tool_setting_id])
REFERENCES [dbo].[tool_setting] ([tool_setting_id])
GO
ALTER TABLE [dbo].[setting_value] CHECK CONSTRAINT [FK_setting_value_setting_value]
GO
ALTER TABLE [dbo].[test_instruction_entry]  WITH CHECK ADD  CONSTRAINT [FK_test_instruction_entry_test_instruction] FOREIGN KEY([test_instruction_id])
REFERENCES [dbo].[test_instruction] ([test_instruction_id])
GO
ALTER TABLE [dbo].[test_instruction_entry] CHECK CONSTRAINT [FK_test_instruction_entry_test_instruction]
GO
ALTER TABLE [dbo].[test_instruction_entry]  WITH CHECK ADD  CONSTRAINT [FK_test_instruction_entry_tool] FOREIGN KEY([tool_id])
REFERENCES [dbo].[tool] ([tool_id])
GO
ALTER TABLE [dbo].[test_instruction_entry] CHECK CONSTRAINT [FK_test_instruction_entry_tool]
GO
ALTER TABLE [dbo].[test_instruction_property]  WITH CHECK ADD  CONSTRAINT [FK_test_instruction_property_test_instruction] FOREIGN KEY([test_instruction_id])
REFERENCES [dbo].[test_instruction] ([test_instruction_id])
GO
ALTER TABLE [dbo].[test_instruction_property] CHECK CONSTRAINT [FK_test_instruction_property_test_instruction]
GO
ALTER TABLE [dbo].[test_instruction_value]  WITH CHECK ADD  CONSTRAINT [FK_test_instruction_value_test_instruction_entry] FOREIGN KEY([test_instruction_entry_id])
REFERENCES [dbo].[test_instruction_entry] ([test_instruction_entry_id])
GO
ALTER TABLE [dbo].[test_instruction_value] CHECK CONSTRAINT [FK_test_instruction_value_test_instruction_entry]
GO
ALTER TABLE [dbo].[tool]  WITH CHECK ADD  CONSTRAINT [FK_tool_test_instruction] FOREIGN KEY([test_instruction_id])
REFERENCES [dbo].[test_instruction] ([test_instruction_id])
GO
ALTER TABLE [dbo].[tool] CHECK CONSTRAINT [FK_tool_test_instruction]
GO
ALTER TABLE [dbo].[tool_setting]  WITH CHECK ADD  CONSTRAINT [FK_tool_setting_article] FOREIGN KEY([article_id])
REFERENCES [dbo].[article] ([id_article])
GO
ALTER TABLE [dbo].[tool_setting] CHECK CONSTRAINT [FK_tool_setting_article]
GO
ALTER TABLE [dbo].[tool_setting]  WITH CHECK ADD  CONSTRAINT [FK_tool_setting_machine] FOREIGN KEY([machine_id])
REFERENCES [dbo].[machine] ([machine_id])
GO
ALTER TABLE [dbo].[tool_setting] CHECK CONSTRAINT [FK_tool_setting_machine]
GO
ALTER TABLE [dbo].[tool_setting]  WITH CHECK ADD  CONSTRAINT [FK_tool_setting_tool] FOREIGN KEY([tool_id])
REFERENCES [dbo].[tool] ([tool_id])
GO
ALTER TABLE [dbo].[tool_setting] CHECK CONSTRAINT [FK_tool_setting_tool]
GO
