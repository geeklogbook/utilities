--
-- PostgreSQL database dump
--

-- Dumped from database version 11.19 (Raspbian 11.19-0+deb10u1)
-- Dumped by pg_dump version 15.2

-- Started on 2023-07-10 19:18:01

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- *not* creating schema, since initdb creates it


ALTER SCHEMA public OWNER TO postgres;

SET default_tablespace = '';

--
-- TOC entry 197 (class 1259 OID 24592)
-- Name: funny-comments; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."funny-comments" (
    id bigint NOT NULL,
    date date,
    reference character varying,
    link character varying,
    author character varying
);


ALTER TABLE public."funny-comments" OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24586)
-- Name: vintage-code; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."vintage-code" (
    id bigint NOT NULL,
    name character varying NOT NULL,
    source_code_link character varying,
    description character varying,
    other_pages character varying
);


ALTER TABLE public."vintage-code" OWNER TO postgres;

--
-- TOC entry 2901 (class 0 OID 24592)
-- Dependencies: 197
-- Data for Name: funny-comments; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."funny-comments" (id, date, reference, link, author) FROM stdin;
1	\N	you are not expected to understand this.	https://github.com/lsahn-gh/unix-v6/blob/2c7099ee501923775c4c96079a6fe94da109b552/sys/ken/slp.c#L317	\N
\.


--
-- TOC entry 2900 (class 0 OID 24586)
-- Dependencies: 196
-- Data for Name: vintage-code; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."vintage-code" (id, name, source_code_link, description, other_pages) FROM stdin;
1	Troff	https://github.com/hollingberry/troff	Is a proto text editor	\N
2	Apollo 11	https://github.com/chrislgarry/Apollo-11	Apollo 11 Source Code	http://www.ibiblio.org/apollo/
3	UNIX 6th	https://github.com/memnoth/unix-v6	UNIX 6th Edition Kernel Source Code	\N
4	UNIX 1fs	https://github.com/qrush/unix	1st Edition UNIX kernel	https://code.google.com/archive/p/unix-jun72/source/default/source
5	Lisa Apple	https://computerhistory.org/blog/the-lisa-apples-most-influential-failure/	Lisa Apple	\N
\.


--
-- TOC entry 2907 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2023-07-10 19:18:02

--
-- PostgreSQL database dump complete
--

