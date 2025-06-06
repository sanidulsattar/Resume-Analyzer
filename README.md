# Resume Analyzer

## Module 1: File Upload API
- Accepts PDF/DOCX files
- Validates file type/size
- Saves to `uploads/` folder

## How to Test
```bash
curl -X POST -F "file=@test.pdf" http://localhost:8080/upload