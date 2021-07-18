#!/usr/bin/env bash
detekt() {
    echo "Running detekt check..."
    OUTPUT="/tmp/detekt-$(date +%s)"
    ./gradlew detekt > $OUTPUT

    if [ $? -eq 0 ]; then
        echo "[PASS] ✅"
    else
      cat $OUTPUT
      rm $OUTPUT
      echo "[FAIL] ⛔️"
      exit 1
    fi
    rm $OUTPUT
}

spotless() {
    echo "Running spotless check..."
    OUTPUT="/tmp/spotless-$(date +%s)"
    ./gradlew spotlessCheck > $OUTPUT

    if [ $? -eq 0 ]; then
        echo "[PASS] ✅"
    else
      cat $OUTPUT
      rm $OUTPUT
      echo "[FAIL] ⛔️"
      exit 1
    fi
    rm $OUTPUT
}

kotlinter() {
    echo "Running kotlin lint check..."
    OUTPUT="/tmp/kotlinter-$(date +%s)"
    ./gradlew lintKotlin > $OUTPUT

    if [ $? -eq 0 ]; then
        echo "[PASS] ✅"
    else
      cat $OUTPUT
      rm $OUTPUT
      echo "[FAIL] ⛔️"
      exit 1
    fi
    rm $OUTPUT
}

lint() {
    echo "Running android lint check..."
    OUTPUT="/tmp/lint-$(date +%s)"
    ./gradlew lint > $OUTPUT

    if [ $? -eq 0 ]; then
        echo "[PASS] ✅"
    else
      cat $OUTPUT
      rm $OUTPUT
      echo "[FAIL] ⛔️"
      exit 1
    fi
    rm $OUTPUT
}

detekt
spotless
kotlinter
lint

## If everything is fine, then exit with a successful code
exit 0