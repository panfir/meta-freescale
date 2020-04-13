FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
require xen.inc

SRCBRANCH = "imx_4.13.y"
XEN_SRC ?= "git://source.codeaurora.org/external/imx/imx-xen.git;protocol=https"

SRC_URI = " \
    ${XEN_SRC};branch=${SRCBRANCH} \
    file://0001-python-pygrub-pass-DISTUTILS-xen.4.12.patch \
    "

SRCREV = "dcef100003b6b78cf83cd50da2031cd087719352"

S = "${WORKDIR}/git"

FILES_${PN}-scripts-common += " ${sysconfdir}/xen/*.cfg"

# provides for qemu build and runtime
PROVIDES = "xen"
RPROVIDES_${PN}-libxenstore += "xen-libxenstore"
RPROVIDES_${PN}-libxenctrl += "xen-libxenctrl"
RPROVIDES_${PN}-libxenguest += "xen-libxenguest"
