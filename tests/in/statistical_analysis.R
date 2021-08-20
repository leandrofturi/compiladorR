#########################
# Statistical Analysis
#########################

# Linear regression!
linearModel <- lm(price  ~ time, data = list1)
linearModel # outputs result of regression
# =>
# Call:
# lm(formula = price ~ time, data = list1)
# 
# Coefficients:
# (Intercept)         time  
#      0.1453       0.4943  
summary(linearModel) # more verbose output from the regression
# =>
# Call:
# lm(formula = price ~ time, data = list1)
#
# Residuals:
#     Min      1Q  Median      3Q     Max 
# -8.3134 -3.0131 -0.3606  2.8016 10.3992 
#
# Coefficients:
#             Estimate Std. Error t value Pr(>|t|)    
# (Intercept)  0.14527    1.50084   0.097    0.923    
# time         0.49435    0.06379   7.749 2.44e-09 ***
# ---
# Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1
#
# Residual standard error: 4.657 on 38 degrees of freedom
# Multiple R-squared:  0.6124,	Adjusted R-squared:  0.6022 
# F-statistic: 60.05 on 1 and 38 DF,  p-value: 2.44e-09
coef(linearModel) # extract estimated parameters
# =>
# (Intercept)        time 
#   0.1452662   0.4943490 
summary(linearModel)$coefficients # another way to extract results
# =>
#              Estimate Std. Error    t value     Pr(>|t|)
# (Intercept) 0.1452662 1.50084246 0.09678975 9.234021e-01
# time        0.4943490 0.06379348 7.74920901 2.440008e-09
summary(linearModel)$coefficients[,4] # the p-values 
# =>
#  (Intercept)         time 
# 9.234021e-01 2.440008e-09 

# GENERAL LINEAR MODELS
# Logistic regression
set.seed(1)
list1$success = rbinom(length(list1$time), 1, .5) # random binary
glModel <- glm(success  ~ time, data = list1, 
	family=binomial(link="logit"))
glModel # outputs result of logistic regression
# =>
# Call:  glm(formula = success ~ time, 
#	family = binomial(link = "logit"), data = list1)
#
# Coefficients:
# (Intercept)         time  
#     0.17018     -0.01321  
# 
# Degrees of Freedom: 39 Total (i.e. Null);  38 Residual
# Null Deviance:	    55.35 
# Residual Deviance: 55.12 	 AIC: 59.12
summary(glModel) # more verbose output from the regression
# =>
# Call:
# glm(formula = success ~ time, 
#	family = binomial(link = "logit"), data = list1)

# Deviance Residuals: 
#    Min      1Q  Median      3Q     Max  
# -1.245  -1.118  -1.035   1.202   1.327  
# 
# Coefficients:
#             Estimate Std. Error z value Pr(>|z|)
# (Intercept)  0.17018    0.64621   0.263    0.792
# time        -0.01321    0.02757  -0.479    0.632
# 
# (Dispersion parameter for binomial family taken to be 1)
#
#     Null deviance: 55.352  on 39  degrees of freedom
# Residual deviance: 55.121  on 38  degrees of freedom
# AIC: 59.121
# 
# Number of Fisher Scoring iterations: 3
