from pydub import AudioSegment

# Cargar el archivo OGG
audio = AudioSegment.from_ogg("ejemplo.ogg")

# Exportar como WAV
audio.export("file.wav", format="wav")

import speech_recognition as sr

# Inicializar el reconocedor
recognizer = sr.Recognizer()

# Cargar el archivo WAV
with sr.AudioFile("file.wav") as source:
    audio_data = recognizer.record(source)
    text = recognizer.recognize_google(audio_data, language='es-ES')

print(text)