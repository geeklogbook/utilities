import yfinance as yf

# Fetching all NYSE stocks
apple = yf.Ticker('AAPL')  # Using NYSE Composite Index

print(apple.info)

