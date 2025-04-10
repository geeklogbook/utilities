library(rstan)
library(dplyr)
library(tidyr)

data("covid_testing", package = "medicaldata")

covid_clean <- covid_testing %>%
  select(-subject_id, -fake_first_name, -fake_last_name) %>%  
  drop_na() %>%  # Eliminar filas con datos faltantes
  mutate_if(is.character, as.factor) %>%  # Convertir variables de texto
  mutate_if(is.numeric, scale)  # Estandarizar

covid_clean <- covid_clean %>%
  mutate(across(where(is.factor), ~ fct_lump_n(.x, n = 3, other_level = "Other")))


X <- model.matrix(~ . -result, data = covid_clean)


y <- as.vector(covid_clean$ct_result)

# Definir los datos para Stan
data_list <- list(
  N = nrow(X),
  K = ncol(X),
  X = X,
  y = y,
  a0 = 1,
  b0 = 1
)


stan_fit_normal <- stan(
  file = "lr_normal.stan",
  data = data_list,
  seed = 2025,  
  chains = 4,
  iter = 2000,
  warmup = 1000,
  thin = 2,
  cores = parallel::detectCores()
)


stan_fit_laplace <- stan(
  file = "lr_laplace.stan",
  data = data_list,
  seed = 2025,
  chains = 4,
  iter = 2000,
  warmup = 1000,
  thin = 2,
  cores = parallel::detectCores()
)


stan_fit_horseshoe <- stan(
  file = "lr_horseshoe.stan",
  data = data_list,
  seed = 2025, 
  chains = 4,
  iter = 2000,
  warmup = 1000,
  thin = 2,
  cores = parallel::detectCores()
)

posterior_samples_normal <- extract(stan_fit_normal)
posterior_samples_laplace <- extract(stan_fit_laplace)
posterior_samples_horseshoe <- extract(stan_fit_horseshoe)

library(bayesplot)
mcmc_intervals(posterior_samples_normal$beta)
mcmc_intervals(posterior_samples_laplace$beta)
mcmc_intervals(posterior_samples_horseshoe$beta)

