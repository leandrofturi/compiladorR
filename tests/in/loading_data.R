#########################
# Loading data
#########################

# "pets.csv" is a file on the internet
# (but it could just as easily be a file on your own computer)
require(RCurl)
pets <- read.csv(textConnection(getURL("https://learnxinyminutes.com/docs/pets.csv")))
pets
head(pets, 2) # first two rows
tail(pets, 1) # last row

# To save a data frame or matrix as a .csv file
write.csv(pets, "pets2.csv") # to make a new .csv file
# set working directory with setwd(), look it up with getwd()

# Try ?read.csv and ?write.csv for more information
