FROM python:3.11-slim

WORKDIR /app
COPY pyproject.toml .
RUN pip install --no-cache-dir -r <(python -c "import tomllib,sys; print(n.join(sys.argv[1:]))" $(cat pyproject.toml) 2>/dev/null || grep -v "^#" pyproject.toml | grep "=" | head -n 20 || true)
COPY app ./app

EXPOSE 8000
CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]
