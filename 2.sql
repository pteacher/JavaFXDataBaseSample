PGDMP                          x            books    10.15    10.15     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �
           1262    16428    books    DATABASE     �   CREATE DATABASE books WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE books;
             ruslan    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                        0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16441 
   authorisbn    TABLE     k   CREATE TABLE public.authorisbn (
    authorid integer NOT NULL,
    isbn character varying(20) NOT NULL
);
    DROP TABLE public.authorisbn;
       public         postgres    false    3                       0    0    TABLE authorisbn    ACL     0   GRANT ALL ON TABLE public.authorisbn TO ruslan;
            public       postgres    false    199            �            1259    16431    authors    TABLE     �   CREATE TABLE public.authors (
    authorid integer NOT NULL,
    firstname character varying(20) NOT NULL,
    lastname character varying(30) NOT NULL
);
    DROP TABLE public.authors;
       public         postgres    false    3                       0    0    TABLE authors    ACL     -   GRANT ALL ON TABLE public.authors TO ruslan;
            public       postgres    false    197            �            1259    16429    authors_authorid_seq    SEQUENCE     �   ALTER TABLE public.authors ALTER COLUMN authorid ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.authors_authorid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    197    3                       0    0    SEQUENCE authors_authorid_seq    ACL     =   GRANT ALL ON SEQUENCE public.authors_authorid_seq TO ruslan;
            public       postgres    false    196            �            1259    16436    titles    TABLE     �   CREATE TABLE public.titles (
    isbn character varying(20) NOT NULL,
    title character varying(100) NOT NULL,
    editionnumber integer NOT NULL,
    copyright character varying(4) NOT NULL
);
    DROP TABLE public.titles;
       public         postgres    false    3                       0    0    TABLE titles    ACL     ,   GRANT ALL ON TABLE public.titles TO ruslan;
            public       postgres    false    198            �
          0    16441 
   authorisbn 
   TABLE DATA               4   COPY public.authorisbn (authorid, isbn) FROM stdin;
    public       postgres    false    199   |       �
          0    16431    authors 
   TABLE DATA               @   COPY public.authors (authorid, firstname, lastname) FROM stdin;
    public       postgres    false    197          �
          0    16436    titles 
   TABLE DATA               G   COPY public.titles (isbn, title, editionnumber, copyright) FROM stdin;
    public       postgres    false    198   �                  0    0    authors_authorid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.authors_authorid_seq', 7, true);
            public       postgres    false    196            w
           2606    16435    authors authors_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (authorid);
 >   ALTER TABLE ONLY public.authors DROP CONSTRAINT authors_pkey;
       public         postgres    false    197            y
           2606    16440    titles titles_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.titles
    ADD CONSTRAINT titles_pkey PRIMARY KEY (isbn);
 <   ALTER TABLE ONLY public.titles DROP CONSTRAINT titles_pkey;
       public         postgres    false    198            z
           2606    16444 #   authorisbn authorisbn_authorid_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.authorisbn
    ADD CONSTRAINT authorisbn_authorid_fkey FOREIGN KEY (authorid) REFERENCES public.authors(authorid);
 M   ALTER TABLE ONLY public.authorisbn DROP CONSTRAINT authorisbn_authorid_fkey;
       public       postgres    false    199    197    2679            {
           2606    16449    authorisbn authorisbn_isbn_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.authorisbn
    ADD CONSTRAINT authorisbn_isbn_fkey FOREIGN KEY (isbn) REFERENCES public.titles(isbn);
 I   ALTER TABLE ONLY public.authorisbn DROP CONSTRAINT authorisbn_isbn_fkey;
       public       postgres    false    2681    199    198            �
   �   x�Mл1��*Ƴ�ߩ���	�Y��$%���������p��������O&�'1�?��1T`K%�&�#���~Y�8��ԳAA:����O��H���)pG��c��h�;bm�{2���Ў�{���	Io      �
   h   x�3�H,��tI�,I��2��H,*K���9��\N��<���̢l.SN�����N����ļ|.3Π�������2.sN��"78#13�4'$���� &3#�      �
   !  x����J�@���).nZ���օ�� $.�L�QG�L����$�)�l\d�sg.A��Q������-�C�CY@�
��������S���TD��EH9�Qǈ����TQ���Z*)��Lk�q�i�Ԇ���O8IP����=�G���gWm�oH]�3%\����$b�\�J� Sæ����!�uҝcd}6���U�O����bjYg1��5�d%�h%�+����]1�vX�&F���QU�b�`U�j���	no���M���ԗ��=tCe�S�]�~���(�~ o���     