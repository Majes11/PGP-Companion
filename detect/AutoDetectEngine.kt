package dev.majes.pgpcompanion.detect

/**
 * Detects PGP blocks in arbitrary text.
 */
class AutoDetectEngine {

    enum class PgpBlockType {
        PUBLIC_KEY,
        PRIVATE_KEY,
        MESSAGE,
        SIGNATURE,
        UNKNOWN
    }

    data class DetectionResult(
        val hasPgpBlock: Boolean,
        val blockType: PgpBlockType?,
        val startIndex: Int?,
        val endIndex: Int?
    )

    /**
     * Scans the given text for PGP blocks and returns basic metadata.
     */
    fun detect(text: String): DetectionResult {
        // TODO: implement simple pattern‑based detection for:
        // -----BEGIN PGP PUBLIC KEY BLOCK-----
        // -----BEGIN PGP PRIVATE KEY BLOCK-----
        // -----BEGIN PGP MESSAGE-----
        // -----BEGIN PGP SIGNATURE-----
        return DetectionResult(
            hasPgpBlock = false,
            blockType = null,
            startIndex = null,
            endIndex = null
        )
    }
}
