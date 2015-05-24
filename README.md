# About
A DoS Attacks Detection System using a Bayesian Network.

# Preliminaries

## Generate SQL Files
1. Compile all Java source files.
2. Run Main.
3. See SQL files generated.

## Populate database
1. create_table.sql
2. fill_table.sql

# Bayesian Network

## Compute Probabilities
* This can be done by querying the database using the generated queries.
* All possible combinations of values needed for computing the conditional probabilities are already generated in separate SQL files.
* See `probs` file.

## Build network
1. Download [SamIam](http://reasoning.cs.ucla.edu/samiam/index.php?s=).
2. Create Bayesian network from computed probabilities. (See `net.png`)

## Query
Test the Bayesian Network using data in the `test` file.


# Notes
* test0 contains the original test set. test0 contains only DoS attacks and some attributes. The other attributes were ignored to make the Bayesian Network simpler.
* The `fill_table.sql` inserts only data which are either DoS attacks or are normal.
* Ignore `values`, `schema`, `metadata` files. They will be used for the documentation only.
* All SQL files work for PostgreSQL. If they do not work in MySQL, modify their corresponding Java files to generate MySQL-compatible syntax.