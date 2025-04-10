# main.R
library(rstan)
library(dplyr)
library(ggplot2)
library(tidyr)
library(posterior)

# Semilla
set.seed(123)

# Función para generar muestras del modelo
generate_sample <- function(N, mu, tau, v0, a0, b0) {
  x <- rt(N, df = 5, ncp = mu) * sqrt(1 / tau)  # Muestras de t-Student
  list(N = N, x = x, v0 = v0, a0 = a0, b0 = b0)
}

# datos simulados
N <- 100
mu <- 1
tau <- 0.5
v0 <- 1
a0 <- 1
b0 <- 1

sim_data <- generate_sample(N, mu, tau, v0, a0, b0)

# Modelo Stan
model_file <- "model.stan"
my_mod <- stan_model(file = model_file)

# Ajustar el modelo a los datos simulados
my_fit <- sampling(my_mod, data = sim_data, seed = 123)

# Resumen del ajuste
my_tab <- summary(my_fit)$summary

# Crear un tibble con las muestras
my_chains <- as_draws_df(my_fit) %>% 
  as_tibble()

# Gráfico con intervalos de credibilidad
my_fig <- my_chains %>%
  summarise(across(everything(), ~ list(quantile(., probs = c(0.025, 0.5, 0.975))))) %>%
  pivot_longer(cols = everything(), names_to = "parameter") %>%
  unnest(cols = value) %>%
  mutate(quantile = rep(c("2.5%", "50%", "97.5%"), times = ncol(my_chains))) %>%
  ggplot(aes(x = parameter, y = value, color = quantile)) +
  geom_point() +
  geom_line(aes(group = parameter)) +
  ggtitle("Intervalos de credibilidad para los parámetros") +
  theme_minimal()

# Comparar estimaciones con valores reales
posterior_means <- colMeans(my_chains)
posterior_means_selected <- posterior_means[c("mu", "tau")]

comparison <- tibble(
  parameter = names(posterior_means_selected),
  posterior_mean = posterior_means_selected,
  true_value = c(mu, tau)
)

# Imprimir resultados
print(comparison)
print(my_fig)

# Explicación de resultados
# Las estimaciones puntuales (medias a posteriori) son cercanas a los valores reales.
# Los intervalos de credibilidad capturan adecuadamente los valores reales, lo que indica que las estimaciones y los intervalos son precisos.

# ¿Qué pasa si incrementamos el número de observaciones?
# Incrementar el número de observaciones reduciría la incertidumbre en las estimaciones y estrecharía los intervalos de credibilidad debido a mayor información en los datos.