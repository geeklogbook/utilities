def bare_bones():
    print("My first Coroutine!")
    try:
        while True:
            value = (yield)
            print(value)
    except GeneratorExit:
        print("Exiting coroutine...")


coroutine = bare_bones()
next(coroutine)
coroutine.send("First Value")
coroutine.send("Second Value")
coroutine.close()