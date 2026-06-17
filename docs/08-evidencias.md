# Evidências

## Evidências Manuais

Capturadas através do método:

```java
capturarEvidencia("nome");
```

Local:

```text
target/screenshots
```

---

## Evidências Automáticas

Capturadas automaticamente em caso de falha.

Implementação:

* TestWatcher
* ScreenshotUtils

Resultado:

* Screenshot anexado ao Extent Report
* Arquivo salvo em target/screenshots
