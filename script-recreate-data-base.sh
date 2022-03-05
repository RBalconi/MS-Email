#!/bin/bash

# drop database
sudo -u postgres psql -c "DROP DATABASE \"ms-email\""

# create database
sudo -u postgres psql -c "CREATE DATABASE \"ms-email\""
