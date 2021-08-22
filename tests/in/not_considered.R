# c(1,2,3) + c(1,2,3) # 2 4 6
# (4 * c(1,2,3) - 2) / 2 # 1 3 5
# c(1,2,3,1,2,3) * c(1,2) # 1 4 3 2 2 6
# c(1,2,3,1,2,3) * c(1,2,1,2,1,2) 
# c(TRUE,FALSE,FALSE) | c(FALSE,TRUE,FALSE) # TRUE TRUE FALSE
# c(TRUE,FALSE,TRUE) & c(FALSE,TRUE,TRUE) # FALSE FALSE TRUE
# c('Z', 'o', 'r', 'r', 'o') == "Zorro" # FALSE FALSE FALSE FALSE FALSE
# c('Z', 'o', 'r', 'r', 'o') == "Z" # TRUE FALSE FALSE FALSE FALSE

# which(vec %% 2 == 0)	# 1 3
# vec * 4	# 16 20 24 28
# vec[2:3] * 5	# 25 30
# any(vec == 10) # TRUE

# any(vec[2:3] == 8) # FALSE
# 3 * mat[,1]	# 3 6 9
# mat %*% t(mat)

# array(c(c(c(2,300,4),c(8,9,0)),c(c(5,60,0),c(66,7,847))), dim=c(3,2,2))

