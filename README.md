# About
A DoS Attacks Detection System using a Bayesian Network.

# Preliminaries
## Database
1. create_table.sql
2. fill_table.sql
3. Remove all rows with classification other than `normal.`, `back.`, `smurf.`, `neptune`. (non-DoS attacks)

## Generate Queries
1. compile all Java source files
2. run Main
3. see SQL files generated

# Bayesian Network
## Compute Probabilities
* This can be done by querying the database using the generated queries.
* See `probs` file.

## Build network
1. Download [SamIam](http://reasoning.cs.ucla.edu/samiam/index.php?s=).
2. Create Bayesian network from computed probabilities.

## Query
Test the Bayesian Network using data in the `test` file.
