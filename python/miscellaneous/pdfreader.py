import PyPDF2

def extract_text_from_pdf(pdf_path):
    with open(pdf_path, 'rb') as file:
        reader = PyPDF2.PdfReader(file)
        text = ''
        for page_num in range(reader.pages):
            page = reader.getPage(page_num)
            text += page.extract_text()
        return text

def extract_specific_section(text):
    start = text.find("ADMINISTRACIÓN CONSORCIO")
    end = text.find("1 DETALLE DE SUELDO Y CARGAS SOCIALES")
    if start != -1 and end != -1:
        return text[start:end]
    return None

pdf_path = '202402.pdf'
text = extract_text_from_pdf(pdf_path)
section_text = extract_specific_section(text)

if section_text:
    print("Extracted Section:")
    print(section_text)
else:
    print("Section not found in the document.")