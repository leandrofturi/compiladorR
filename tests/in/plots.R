#########################
# Plots
#########################

# BUILT-IN PLOTTING FUNCTIONS
# Scatterplots!
plot(list1$time, list1$price, main = "fake data")
# Plot regression line on existing plot
abline(linearModel, col = "red")
# Get a variety of nice diagnostics
plot(linearModel)
# Histograms!
hist(rpois(n = 10000, lambda = 5), col = "thistle")
# Barplots!
barplot(c(1,4,5,1,2), names.arg = c("red","blue","purple","green","yellow"))
