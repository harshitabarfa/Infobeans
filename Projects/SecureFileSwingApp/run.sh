
#!/usr/bin/env bash
set -e
SRC="src"
OUT="out"
rm -rf "$OUT"
mkdir -p "$OUT"
find "$SRC" -name "*.java" -print0 | xargs -0 javac -d "$OUT"
( cd "$OUT" && java app.Main )
